package you.thiago.cdp.ui.authentication.register

import android.util.Patterns
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpForm {
    val email = MutableStateFlow("")
    val name = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun isEmailValid(): Boolean {
        return if (email.value.isBlank()) {
            false
        } else if (!email.value.contains('@')) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(email.value).matches()
        }
    }

    fun isNameValid(): Boolean {
        return name.value.length > 5
    }

    fun isPasswordValid(): Boolean {
        return password.value.length > 5
    }
}