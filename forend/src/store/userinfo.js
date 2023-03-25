


export default {
    state: {
        islogin: false,
        username: "",
        token: "",
    },
    mutations: {
        logout(state) {
            state.username = "";
            state.islogin = false;
            // state.token = '';
        },
        changelogin(state, a) {
            state.islogin = a
        },
        showusername(state, n) {
            state.username = n
        },
        updateToken(state, token) {
            state.token = token;
        },

    },

    actions: {
        // deletetoken(state) {
        //     state.token = '';
        // }
    }
}