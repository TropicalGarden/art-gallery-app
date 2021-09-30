package com.example.artgallery.network.model

import com.squareup.moshi.Json

object TokenRequest {

    @Json(name = "grant_type")
    val grantType: String = "client_credentials"

    //  You can get client id and client secret upon registering application
    //  at https://www.deviantart.com/developers/

    //  TODO Replace "placeholder" with deviant art api client id
    //  Example: val clientId: String = "19183"
    @Json(name = "client_id")
    val clientId: String = "placeholder"

    //  TODO Replace "placeholder" with deviant art api client secret
    //  Example: val clientSecret: String = "2934el243r3r58dd90ds3sd4t7u26g91"
    @Json(name = "client_secret")
    val clientSecret: String = "placeholder"

}
