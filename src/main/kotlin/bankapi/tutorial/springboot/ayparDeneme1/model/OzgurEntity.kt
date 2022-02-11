package bankapi.tutorial.springboot.ayparDeneme1.model

data class OzgurEntity(
    val name: String,
    val message: String?
) {

    companion object {
        fun of(
            name: String = "Mahm00d",
            message: String? = null
        ): OzgurEntity {
            return OzgurEntity(
                name = name,
                message = message
            )
        }
    }
}