'use strict'

function checkPasswords() {
    var password = document.getElementById('password');
    var repeat_password = document.getElementById('repeat_password');
    var submit = document.getElementById('submit');
    if (password.value === repeat_password.value) {
        submit.removeAttribute('disabled');
    } else {
        submit.setAttribute('disabled', 'disabled');
    }
}