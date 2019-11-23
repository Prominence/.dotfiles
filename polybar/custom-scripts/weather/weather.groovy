#!/usr/bin/env groovy
@Grab(group='com.github.prominence', module='openweathermap-api', version='1.2')

import com.github.prominence.openweathermap.api.OpenWeatherMapManager
import com.github.prominence.openweathermap.api.WeatherRequester
import com.github.prominence.openweathermap.api.model.response.Weather
import com.github.prominence.openweathermap.api.constants.Unit
import com.github.prominence.openweathermap.api.constants.Language
import com.github.prominence.openweathermap.api.constants.Accuracy


final String API_TOKEN_FILE = '/home/prominence/.config/polybar/custom-scripts/weather/openweathermap.token'
final String API_TOKEN = new File(API_TOKEN_FILE).text?.trim()

OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager(API_TOKEN)
WeatherRequester weatherRequester = openWeatherManager.getWeatherRequester()

Weather weather = weatherRequester
    .setLanguage(Language.ENGLISH)
    .setUnitSystem(Unit.METRIC_SYSTEM)
    .setAccuracy(Accuracy.ACCURATE)
    .getByCityName("Minsk")

println "${getWeatherIcon(weather)} ${weather.weatherDescription} ${weather.temperature}°C"

String getWeatherIcon(Weather weather) {
	final String iconId = weather.weatherStates[0].iconId
	switch(iconId) {
		case '01d': return ''
		case '01n': return ''
		case '02d': return ''
		case '02n': return ''
		case ~/^03*$/: return ''
		case ~/^04*$/: return ''
		case '09d': return ''
		case '09n': return ''
		case '10d': return ''
		case '10n': return ''
		case '11d': return ''
		case '11n': return ''
		case '13d': return ''
		case '13n': return ''
		case '50d': return ''
		case '50n': return ''
		default: return ''
	}
}