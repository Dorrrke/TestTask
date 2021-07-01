import com.google.gson.annotations.SerializedName

data class Phones (

	@SerializedName("number") val number : String,
	@SerializedName("type") val type : String,
	@SerializedName("comment") val comment : String,
	@SerializedName("primary") val primary : Boolean
)