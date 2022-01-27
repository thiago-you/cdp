package you.thiago.cdp.ui.authentication.register

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import you.thiago.cdp.R
import java.lang.ref.WeakReference
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val weakContext = WeakReference(context)

    val signUpForm: StateFlow<SignUpForm> = MutableStateFlow(SignUpForm())

    private val _signUpFormState = MutableStateFlow(SignUpFormState())
    val signUpFormState: StateFlow<SignUpFormState> = _signUpFormState

    private val _signUpResult = MutableStateFlow(SignUpResult())
    val signUpResult: StateFlow<SignUpResult> = _signUpResult

    init {
        setupListeners()
    }

    fun signUp() {
        val result = Auth().signUp()

        if (result) {
            _signUpResult.value = SignUpResult(success = "Teste")
        } else {
            _signUpResult.value = SignUpResult(error = R.string.sign_up_failed)
        }
    }

    private fun setupListeners() {
        viewModelScope.launch {
            signUpForm.value.email.collect {
                signUpDataChanged()
            }
        }

        viewModelScope.launch {
            signUpForm.value.name.collect {
                signUpDataChanged()
            }
        }

        viewModelScope.launch {
            signUpForm.value.password.collect {
                signUpDataChanged()
            }
        }
    }

    private fun signUpDataChanged() {
        if (!signUpForm.value.isEmailValid()) {
            _signUpFormState.value = SignUpFormState(emailError = R.string.invalid_email)
        } else if (!signUpForm.value.isNameValid()) {
            _signUpFormState.value = SignUpFormState(nameError = R.string.invalid_name)
        } else if (!signUpForm.value.isPasswordValid()) {
            _signUpFormState.value = SignUpFormState(passwordError = R.string.invalid_password)
        }
    }

    class Auth {
        fun signUp(): Boolean {
            return true
        }
    }
}