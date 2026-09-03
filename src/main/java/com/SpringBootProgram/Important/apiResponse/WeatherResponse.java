//package com.SpringBootProgram.Important.apiResponse;
//
//
//     import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
///* ObjectMapper om = new ObjectMapper();
//Root root = om.readValue(myJsonString, Root.class); */
//public class WeatherResponse{
//    public class AirQuality{
//        @JsonProperty("co")
//        public String getCo() {
//            return this.co; }
//        public void setCo(String co) {
//            this.co = co; }
//        String co;
//        @JsonProperty("no2")
//        public String getNo2() {
//            return this.no2; }
//        public void setNo2(String no2) {
//            this.no2 = no2; }
//        String no2;
//        @JsonProperty("o3")
//        public String getO3() {
//            return this.o3; }
//        public void setO3(String o3) {
//            this.o3 = o3; }
//        String o3;
//        @JsonProperty("so2")
//        public String getSo2() {
//            return this.so2; }
//        public void setSo2(String so2) {
//            this.so2 = so2; }
//        String so2;
//        @JsonProperty("pm2_5")
//        public String getPm2_5() {
//            return this.pm2_5; }
//        public void setPm2_5(String pm2_5) {
//            this.pm2_5 = pm2_5; }
//        String pm2_5;
//        @JsonProperty("pm10")
//        public String getPm10() {
//            return this.pm10; }
//        public void setPm10(String pm10) {
//            this.pm10 = pm10; }
//        String pm10;
//        @JsonProperty("us-epa-index")
//        public String getUs-epa-index() {
//            return this.us-epa-index; }
//        public void setUs-epa-index(String us-epa-index) {
//            this.us-epa-index = us-epa-index; }
//        String us-epa-index;
//        @JsonProperty("gb-defra-index")
//        public String getGb-defra-index() {
//            return this.gb-defra-index; }
//        public void setGb-defra-index(String gb-defra-index) {
//            this.gb-defra-index = gb-defra-index; }
//        String gb-defra-index;
//    }
//
//    public class Astro{
//        @JsonProperty("sunrise")
//        public String getSunrise() {
//            return this.sunrise; }
//        public void setSunrise(String sunrise) {
//            this.sunrise = sunrise; }
//        String sunrise;
//        @JsonProperty("sunset")
//        public String getSunset() {
//            return this.sunset; }
//        public void setSunset(String sunset) {
//            this.sunset = sunset; }
//        String sunset;
//        @JsonProperty("moonrise")
//        public String getMoonrise() {
//            return this.moonrise; }
//        public void setMoonrise(String moonrise) {
//            this.moonrise = moonrise; }
//        String moonrise;
//        @JsonProperty("moonset")
//        public String getMoonset() {
//            return this.moonset; }
//        public void setMoonset(String moonset) {
//            this.moonset = moonset; }
//        String moonset;
//        @JsonProperty("moon_phase")
//        public String getMoon_phase() {
//            return this.moon_phase; }
//        public void setMoon_phase(String moon_phase) {
//            this.moon_phase = moon_phase; }
//        String moon_phase;
//        @JsonProperty("moon_illumination")
//        public int getMoon_illumination() {
//            return this.moon_illumination; }
//        public void setMoon_illumination(int moon_illumination) {
//            this.moon_illumination = moon_illumination; }
//        int moon_illumination;
//    }
//
//    public class Current{
//        @JsonProperty("observation_time")
//        public String getObservation_time() {
//            return this.observation_time; }
//        public void setObservation_time(String observation_time) {
//            this.observation_time = observation_time; }
//        String observation_time;
//        @JsonProperty("temperature")
//        public int getTemperature() {
//            return this.temperature; }
//        public void setTemperature(int temperature) {
//            this.temperature = temperature; }
//        int temperature;
//        @JsonProperty("weather_code")
//        public int getWeather_code() {
//            return this.weather_code; }
//        public void setWeather_code(int weather_code) {
//            this.weather_code = weather_code; }
//        int weather_code;
//        @JsonProperty("weather_icons")
//        public ArrayList<String> getWeather_icons() {
//            return this.weather_icons; }
//        public void setWeather_icons(ArrayList<String> weather_icons) {
//            this.weather_icons = weather_icons; }
//        ArrayList<String> weather_icons;
//        @JsonProperty("weather_descriptions")
//        public ArrayList<String> getWeather_descriptions() {
//            return this.weather_descriptions; }
//        public void setWeather_descriptions(ArrayList<String> weather_descriptions) {
//            this.weather_descriptions = weather_descriptions; }
//        ArrayList<String> weather_descriptions;
//        @JsonProperty("astro")
//        public Astro getAstro() {
//            return this.astro; }
//        public void setAstro(Astro astro) {
//            this.astro = astro; }
//        Astro astro;
//        @JsonProperty("air_quality")
//        public AirQuality getAir_quality() {
//            return this.air_quality; }
//        public void setAir_quality(AirQuality air_quality) {
//            this.air_quality = air_quality; }
//        AirQuality air_quality;
//        @JsonProperty("wind_speed")
//        public int getWind_speed() {
//            return this.wind_speed; }
//        public void setWind_speed(int wind_speed) {
//            this.wind_speed = wind_speed; }
//        int wind_speed;
//        @JsonProperty("wind_degree")
//        public int getWind_degree() {
//            return this.wind_degree; }
//        public void setWind_degree(int wind_degree) {
//            this.wind_degree = wind_degree; }
//        int wind_degree;
//        @JsonProperty("wind_dir")
//        public String getWind_dir() {
//            return this.wind_dir; }
//        public void setWind_dir(String wind_dir) {
//            this.wind_dir = wind_dir; }
//        String wind_dir;
//        @JsonProperty("pressure")
//        public int getPressure() {
//            return this.pressure; }
//        public void setPressure(int pressure) {
//            this.pressure = pressure; }
//        int pressure;
//        @JsonProperty("precip")
//        public double getPrecip() {
//            return this.precip; }
//        public void setPrecip(double precip) {
//            this.precip = precip; }
//        double precip;
//        @JsonProperty("humidity")
//        public int getHumidity() {
//            return this.humidity; }
//        public void setHumidity(int humidity) {
//            this.humidity = humidity; }
//        int humidity;
//        @JsonProperty("cloudcover")
//        public int getCloudcover() {
//            return this.cloudcover; }
//        public void setCloudcover(int cloudcover) {
//            this.cloudcover = cloudcover; }
//        int cloudcover;
//        @JsonProperty("feelslike")
//        public int getFeelslike() {
//            return this.feelslike; }
//        public void setFeelslike(int feelslike) {
//            this.feelslike = feelslike; }
//        int feelslike;
//        @JsonProperty("uv_index")
//        public int getUv_index() {
//            return this.uv_index; }
//        public void setUv_index(int uv_index) {
//            this.uv_index = uv_index; }
//        int uv_index;
//        @JsonProperty("visibility")
//        public int getVisibility() {
//            return this.visibility; }
//        public void setVisibility(int visibility) {
//            this.visibility = visibility; }
//        int visibility;
//        @JsonProperty("is_day")
//        public String getIs_day() {
//            return this.is_day; }
//        public void setIs_day(String is_day) {
//            this.is_day = is_day; }
//        String is_day;
//    }
//
//    public class Location{
//        @JsonProperty("name")
//        public String getName() {
//            return this.name; }
//        public void setName(String name) {
//            this.name = name; }
//        String name;
//        @JsonProperty("country")
//        public String getCountry() {
//            return this.country; }
//        public void setCountry(String country) {
//            this.country = country; }
//        String country;
//        @JsonProperty("region")
//        public String getRegion() {
//            return this.region; }
//        public void setRegion(String region) {
//            this.region = region; }
//        String region;
//        @JsonProperty("lat")
//        public String getLat() {
//            return this.lat; }
//        public void setLat(String lat) {
//            this.lat = lat; }
//        String lat;
//        @JsonProperty("lon")
//        public String getLon() {
//            return this.lon; }
//        public void setLon(String lon) {
//            this.lon = lon; }
//        String lon;
//        @JsonProperty("timezone_id")
//        public String getTimezone_id() {
//            return this.timezone_id; }
//        public void setTimezone_id(String timezone_id) {
//            this.timezone_id = timezone_id; }
//        String timezone_id;
//        @JsonProperty("localtime")
//        public String getLocaltime() {
//            return this.localtime; }
//        public void setLocaltime(String localtime) {
//            this.localtime = localtime; }
//        String localtime;
//        @JsonProperty("localtime_epoch")
//        public int getLocaltime_epoch() {
//            return this.localtime_epoch; }
//        public void setLocaltime_epoch(int localtime_epoch) {
//            this.localtime_epoch = localtime_epoch; }
//        int localtime_epoch;
//        @JsonProperty("utc_offset")
//        public String getUtc_offset() {
//            return this.utc_offset; }
//        public void setUtc_offset(String utc_offset) {
//            this.utc_offset = utc_offset; }
//        String utc_offset;
//    }
//
//    public class Request{
//        @JsonProperty("type")
//        public String getType() {
//            return this.type; }
//        public void setType(String type) {
//            this.type = type; }
//        String type;
//        @JsonProperty("query")
//        public String getQuery() {
//            return this.query; }
//        public void setQuery(String query) {
//            this.query = query; }
//        String query;
//        @JsonProperty("language")
//        public String getLanguage() {
//            return this.language; }
//        public void setLanguage(String language) {
//            this.language = language; }
//        String language;
//        @JsonProperty("unit")
//        public String getUnit() {
//            return this.unit; }
//        public void setUnit(String unit) {
//            this.unit = unit; }
//        String unit;
//    }
//
//    public class Root{
//        @JsonProperty("request")
//        public Request getRequest() {
//            return this.request; }
//        public void setRequest(Request request) {
//            this.request = request; }
//        Request request;
//        @JsonProperty("location")
//        public Location getLocation() {
//            return this.location; }
//        public void setLocation(Location location) {
//            this.location = location; }
//        Location location;
//        @JsonProperty("current")
//        public Current getCurrent() {
//            return this.current; }
//        public void setCurrent(Current current) {
//            this.current = current; }
//        Current current;
//    }
//
//
//}
