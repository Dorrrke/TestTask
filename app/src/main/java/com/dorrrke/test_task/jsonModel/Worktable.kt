import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Worktable (

	@SerializedName("department") val department : String = "",
	@SerializedName("monday") val monday : String,
	@SerializedName("tuesday") val tuesday : String,
	@SerializedName("wednesday") val wednesday : String,
	@SerializedName("thursday") val thursday : String,
	@SerializedName("friday") val friday : String,
	@SerializedName("saturday") val saturday : String,
	@SerializedName("sunday") val sunday : String,
	@SerializedName("timetable") val timetable : String
) : Serializable