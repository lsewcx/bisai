<template>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container">
            <a class="navbar-brand"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <RouterLink class="nav-link" aria-current="page" :to="{ name: 'HomeView' }">智能代码溯源系统
                        </RouterLink>
                    </li>
                </ul>
                <ul class="nav-item dropdown" v-if="gettoken">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-gear-fill" viewBox="0 0 16 16" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <path
                            d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z" />
                    </svg>
                    <ul class="dropdown-menu">
                        <li>
                            <RouterLink class="dropdown-item" href="#" :to="{name: 'PersonalView'}">个人中心</RouterLink>
                        </li>
                        <li>
                            <RouterLink @click="tishikuang" class="dropdown-item" href="#" :to="{name: 'HomeView'}">退出登录
                            </RouterLink>
                        </li>
                    </ul>
                </ul>
                <ul class="navbar-nav" v-else>
                    <li class="nav-item">
                        <RouterLink class="nav-link" :to="{ name: 'RegisterView' }">注册</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink class="nav-link" :to="{ name: 'LoginView' }">登录</RouterLink>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</template>

<script setup>
    import { computed, reactive, ref, watchEffect } from 'vue'
    import { useStore } from 'vuex'
    import router from '../router/index'
    import $ from 'jquery'
    import { onMounted } from 'vue';
    import { watch } from 'vue';
    import created from 'vue'




    const store = useStore()
    // const gettoken = computed(() => {
    //     return store.state.userinfo.token
    // })


    const gettoken = computed(() => {
        return localStorage.getItem("jwt_token")
    })


    const logout = () => {
        store.commit("logout");
        localStorage.removeItem("jwt_token");
        location.reload()
    }

    const tishikuang = () => {
        var r = confirm("你确定要退出吗");
        if (r == true) {
            logout();
        }

    }

    function change() {
        if (location.href.indexOf("#reloaded") == -1) {
            location.href = location.href + "#reloaded";
            location.reload();
        }
    }

    watch(() => store.state.userinfo.token, (newValue, oldValue) => {
        if (newValue === oldValue || !newValue || !oldValue) {//保证没有新值和旧值的情况下页面步跳转到HomeView
            return
        }
        else {
            change()
            router.push({ name: "HomeView" })
        }
    }, {
        immediate: true,
        deep: true
    })



</script>

<style scoped>
    .container {
        margin-top: 0px;
    }

    .nav-item {
        font-size: larger;
    }

    .navbar-nav {
        height: 70px;
    }

    .select {
        border: 0;
        background: none;
        height: 50px;
    }

    .nav-link {
        border: none;
        background: none;
    }
</style>