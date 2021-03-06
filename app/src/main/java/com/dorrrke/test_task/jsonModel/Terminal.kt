import com.google.gson.annotations.SerializedName

data class Terminal (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("address") val address : String,
	@SerializedName("fullAddress") val fullAddress : String,
	@SerializedName("latitude") val latitude : Double,
	@SerializedName("longitude") val longitude : Double,
	@SerializedName("phones") val phones : List<Phones>,
	@SerializedName("storage") val storage : Boolean,
	@SerializedName("mail") val mail : String,
	@SerializedName("mainPhone") val mainPhone : String,
	@SerializedName("isPVZ") val isPVZ : Boolean,
	@SerializedName("isOffice") val isOffice : Boolean,
	@SerializedName("receiveCargo") val receiveCargo : Boolean,
	@SerializedName("giveoutCargo") val giveoutCargo : Boolean,
	@SerializedName("maps") val maps : Maps,
	@SerializedName("addressCode") val addressCode : AddressCode,
	@SerializedName("calcSchedule") val calcSchedule : CalcSchedule,
	@SerializedName("default") val default : Boolean,
	@SerializedName("maxWeight") val maxWeight : String,
	@SerializedName("maxLength") val maxLength : String,
	@SerializedName("maxWidth") val maxWidth : Double,
	@SerializedName("maxHeight") val maxHeight : Double,
	@SerializedName("maxVolume") val maxVolume : String,
	@SerializedName("maxShippingWeight") val maxShippingWeight : String,
	@SerializedName("maxShippingVolume") val maxShippingVolume : String,
	@SerializedName("worktables") val worktables : Worktables
)