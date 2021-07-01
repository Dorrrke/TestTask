import com.google.gson.annotations.SerializedName

data class Width (

	@SerializedName("640") val mediumSize : MediumSize640,
	@SerializedName("944") val bigWidth : BigWidth944,
	@SerializedName("960") val bigSize: BigSize960
)