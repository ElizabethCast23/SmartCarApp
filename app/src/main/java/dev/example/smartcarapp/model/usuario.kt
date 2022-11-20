package dev.example.smartcarapp.model

data class usuario(
    val apellido: String="",
    val nombre: String="",
    val contraseña: String="",
    val confi_contra: String="",
    val correo: String="",
    val documento: String="",
    val fech_nac: String="",
    val tel_cel: String="",
    val tipo: Number=0

)
