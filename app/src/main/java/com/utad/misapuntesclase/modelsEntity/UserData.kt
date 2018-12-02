package com.utad.misapuntesclase.modelsEntity

import android.net.Uri
import java.util.*
import android.arch.persistence.room.Entity

/**
 * Clase que contendrá los datos del usuario en local mientras este en la aplicación
 *
 * es accesible desde cualquier sitio
 */

@Entity(tableName = "user")
public class UserData(
    var name: String,
    var surname1: String,
    var surname2: String,
    var address: String?,
    var postalCode: Int?,
    var city: String?,
    var phone: Int?,
    var date: Date?,

    var imgUser: Uri?,
    var gender: Gender?,
    var description: String?,
    var email: String?,
    var hobbies: Array<String>? ){

    companion object {
        @Volatile
        private var INSTANCE: UserData? = null

        fun getInstance(): UserData = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: UserData(
                        "", "", "", null, 0, null, 0,
                        null, null, Gender.female, null, null, null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}

// Clase creada para acotar los valores de Gender
enum class Gender {
    female, male
}