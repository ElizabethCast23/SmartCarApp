package dev.example.smartcarapp.model

data class paqueteViaje(
    val bus_id: Number=0,
    val dia: String="",
    val is_delete: Boolean = false,
    val ruta_id: Number=0,
    val tiempo: String="",
)
