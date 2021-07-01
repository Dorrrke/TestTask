import com.google.gson.annotations.SerializedName



data class CalcSchedule (

	@SerializedName("derival") val derival : String,
	@SerializedName("arrival") val arrival : String
)