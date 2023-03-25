<template>
    <form>
        <ContentBase>
            <div class="success">注册成功</div>
            <div class="spinner"></div>
            <div class="login">{{ state.counter }}秒后前往登录页面</div>
            <meta http-equiv="refresh" content="3;URL=/LoginView">
        </ContentBase>
    </form>
</template>

<script setup>
    import ContentBase from '../components/ContentBase.vue'
    import { ref } from 'vue'
    import { reactive, onUnmounted, router } from 'vue';


    const state = reactive({
        counter: 3
    })
    const timer = setInterval(() => {
        state.counter--
    }, 1000);

    onUnmounted(() => {
        clearInterval(timer);
    })

</script>

<style scope> 
    .success {
        text-align: center;
        line-height: 400px;
        font-size: 100px
    }

    .login {
        text-align: center;
        font-size: 30px;

    }


    .spinner {
        margin: auto;

        /* Size */
        height: 4rem;
        width: 4rem;
        /* Create a curve at the top */
        border: 4px solid #d1d5db;
        border-top-color: #3b82f6;
        border-radius: 50%;

        animation: spinner 800ms linear infinite;
    }

    @keyframes spinner {
        from {
            transform: rotate(0deg);
        }

        to {
            transform: rotate(360deg);
        }
    }
</style>