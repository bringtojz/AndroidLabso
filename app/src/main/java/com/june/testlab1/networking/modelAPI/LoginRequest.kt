package com.june.testlab1.networking.modelAPI

import com.squareup.moshi.Json


data class LoginRequest(

	@Json(name="refresh_token")
	val refreshToken: String? = "",

	@Json(name="access_type")
	val accessType: String? = "",

	@Json(name="user_id")
	val userId: String? = "",

	@Json(name="grant_type")
	val grantType: String? = "",

	@Json(name="user_pwd")
	val userPwd: String? = ""


)