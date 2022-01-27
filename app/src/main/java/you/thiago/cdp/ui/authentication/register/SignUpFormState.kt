package you.thiago.cdp.ui.authentication.register

/**
 * Data validation state of the sign up form.
 */
data class SignUpFormState (
    val emailError: Int? = null,
    val nameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)