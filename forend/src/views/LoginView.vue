<template>
    <form class="form" @submit.prevent="login">
        <ContentBase>
            <div class=" mb-3">
                <label for="exampleInputUsername" class="form-label">用户名:</label>
                <input type="username" class="form-control" id="exampleInputUsername" aria-describedby="emailHelp"
                    v-model="username">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">密码:</label>
                <input type="password" class="form-control" id="exampleInputPassword1" v-model="password">
            </div>
            <canvas id="mycanvas" @click="code(options)"></canvas><br /><br />
            <input type="text" class="form-control" id="exampleInputPassword1" v-model="yanzhengma" maxlength="4"
                placeholder="区分大小写">
            <div class="error_message">{{ error_message }}</div>
            <div class="button">
                <button type="submit" class="btn-bd-primary">登录</button>
            </div>
        </ContentBase>
    </form>
</template>

<script setup>
    import $ from 'jquery';
    import { reactive, ref } from 'vue';
    import router from '../router/index'
    import ContentBase from '../components/ContentBase.vue'
    import { defineEmits } from 'vue'
    import { useStore } from 'vuex'
    import { onMounted } from 'vue';

    let username = ref('');
    let password = ref('');
    let error_message = ref('');
    let yanzhengma = ref('');
    error_message.value = "";
    const store = useStore()

    const login = () => {
        if (yanzhengma.value == options.txt) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/token/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                },
                success(resp) {
                    store.commit('changelogin', true)
                    store.commit('showusername', username.value);
                    store.commit('updateToken', resp.token)
                    localStorage.setItem("jwt_token", resp.token);
                    router.push({ name: "HomeView" })
                },
                error() {
                    error_message.value = "用户名或密码错误";
                }
            });
        }
        else {
            error_message.value = "验证码错误";
        }
    }



    var options = {
        canvasId: 'mycanvas',
        width: 200,
        height: 50,
        txt: ''
    }
    //生产验证码
    function produceCode(options) {
        var code = "";
        var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        for (let i = 0; i < 4; i++) {
            var index = Math.floor(Math.random() * 62);
            code += random[index];
        }
        options.txt = code;
    }
    //产生随机数字
    function randomNum(min, max) {
        return Math.floor(Math.random() * (max - min) + min);
    }
    //产生随机颜色
    function randomColor(min, max) {
        var r = randomNum(min, max);
        var g = randomNum(min, max);
        var b = randomNum(min, max);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
    //生产验证码背景
    function code(options) {
        produceCode(options);
        var canvas = document.getElementById(options.canvasId);
        canvas.width = options.width || 300;//画布的宽
        canvas.height = options.height || 150;//画布的高
        var ctx = canvas.getContext("2d");//创建一个canvas对象
        ctx.textBaseline = "middle";
        ctx.fillStyle = randomColor(60, 255);
        ctx.fillRect(0, 0, canvas.width, canvas.height);
        for (let i = 0; i < options.txt.length; i++) {
            var txt = options.txt.charAt(i);
            ctx.font = '50px SimHei';
            ctx.fillStyle = randomColor(60, 180); /**随机生成字体颜色*/
            ctx.shadowOffsetY = randomNum(-3, 3);
            ctx.shadowBlur = randomNum(-3, 3);
            ctx.shadowColor = "rgba(0, 0, 0, 0.3)";
            var x = options.width / (options.txt.length + 1) * (i + 1);
            var y = options.height / 2;
            var deg = randomNum(-30, 30);
            /**设置旋转角度和坐标原点*/
            ctx.translate(x, y);
            ctx.rotate(deg * Math.PI / 180);
            ctx.fillText(txt, 0, 0);
            /**恢复旋转角度和坐标原点*/
            ctx.rotate(-deg * Math.PI / 180);
            ctx.translate(-x, -y);
        }

        /**1~4条随机干扰线随机出现*/
        for (let i = 0; i < randomNum(1, 4); i++) {
            ctx.strokeStyle = randomColor(40, 180);
            ctx.beginPath();
            ctx.moveTo(randomNum(0, options.width), randomNum(0, options.height));
            ctx.lineTo(randomNum(0, options.width), randomNum(0, options.height));
            ctx.stroke();
        }
        /**绘制干扰点*/
        for (let i = 0; i < options.width / 6; i++) {
            ctx.fillStyle = randomColor(0, 255);
            ctx.beginPath();
            ctx.arc(randomNum(0, options.width), randomNum(0, options.height), 1, 0, 2 * Math.PI);
            ctx.fill();
        }
    }

    $(function () { code(options) });//让验证码一开始就加载出来

</script>



<style scoped>
    .btn-bd-primary {
        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet);
        --bs-btn-border-color: var(--bd-violet);
        --bs-btn-border-radius: .5rem;
        --bs-btn-hover-color: var(--bs-white);
    }

    .error_message {
        color: red;
        text-align: center;
    }

    .form {
        position: absolute;
        top: 30%;
        left: 40%;
    }

    .mb-3 {

        text-align: center;

    }

    .button {
        text-align: center;
    }
</style>