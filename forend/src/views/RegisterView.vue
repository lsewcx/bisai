<template>
    <form class="form" @submit.prevent="submitdata">
        <ContentBase>
            <div class="mb-3">
                <label for="exampleInputUsername" class="form-label">用户名:</label>
                <input type="username" class="form-control" id="exampleInputUsername" aria-describedby="emailHelp"
                    v-model="username">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">密码:</label>
                <input type="password" class="form-control" id="exampleInputPassword1" v-model="password">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword2" class="form-label">确认密码:</label>
                <input type="Password" class="form-control" id="exampleInputPassword1" v-model="confirmedPassword">
            </div>
            <div class="error_message">{{ error_message }}</div>
            <div class="button">
                <button type="submit" class="btn-bd-primary">注册</button>
            </div>
        </ContentBase>
    </form>
</template>


<script setup>


    import { ref } from 'vue';
    import $ from 'jquery';
    import router from '../router/index'
    import ContentBase from '../components/ContentBase.vue'


    const username = ref("");
    const password = ref("");
    const confirmedPassword = ref("");
    let error_message = ref('');



    const submitdata = () => {
        if (password.value == confirmedPassword.value) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: confirmedPassword.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        router.push({ path: '/RegisterSuccess' });
                    }
                    else {
                        error_message.value = resp.error_message;
                    }

                },
                error() {
                    error_message.value = "两次密码不一致";
                }
            })
        }
        else {
            error_message.value = "两次密码不一致";
        }

    }

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