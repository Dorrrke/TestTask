import com.google.gson.annotations.SerializedName


data class CityList (

	@SerializedName("city") val city : List<City>
)