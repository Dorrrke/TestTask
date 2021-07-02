import com.google.gson.annotations.SerializedName


data class Height (

	@SerializedName("960") val bigSize: BigSize960,
	@SerializedName("352") val smallHeight: SmallHeight352,
	@SerializedName("640") val mediumSize: MediumSize640
)