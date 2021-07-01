import com.google.gson.annotations.SerializedName



data class City (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("code") val code : Int,
	@SerializedName("cityID") val cityID : Int,
	@SerializedName("latitude") val latitude : Double,
	@SerializedName("longitude") val longitude : Double,
	@SerializedName("url") val url : String,
	@SerializedName("timeshift") val timeshift : Int,
	@SerializedName("requestEndTime") val requestEndTime : String,
	@SerializedName("sfrequestEndTime") val sfrequestEndTime : String,
	@SerializedName("day2dayRequest") val day2dayRequest : Int,
	@SerializedName("day2daySFRequest") val day2daySFRequest : Int,
	@SerializedName("preorderRequest") val preorderRequest : Int,
	@SerializedName("freeStorageDays") val freeStorageDays : Int,
	@SerializedName("terminals") val terminals : Terminals
)