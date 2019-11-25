package org.itdevelopers.deportesunq.net

import android.util.Log
import com.google.gson.*
import org.itdevelopers.deportesunq.model.Competition
import org.itdevelopers.deportesunq.model.Competitions
import java.lang.reflect.Type

//https://stackoverflow.com/a/44118828/5279996
class JsonCompetitionsDeserializer: JsonDeserializer<Competitions> {

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): Competitions {
        val competitions = Competitions()
        if (json.isJsonObject) {
            for ((key, value) in json.asJsonObject.entrySet()) {
                if (key == "status") {
                    Log.d("Test", "Primitive: " + key.toString() + value.asString)
                    competitions.setStatus(value.asString)
                } else if (key == "body") {
                    Log.d("Test", "Object: key: $key = $value")


                    Log.d("Test", "JsonArray: ${value.asJsonArray}")
                    val jsonArray = value.asJsonArray

                    for (element in jsonArray) {
                        Log.d("Test", "Element: " + element.asJsonObject.toString())
//                        No usar asJsonObject.entrySet sino no puedo acceder a los valores del objeto
                        val jsonObject = element.asJsonObject

//                        Borra el primer y último caracter, es decir, las comillas
                        Log.d("Test", jsonObject.get("name").toString().drop(1).dropLast(1))
                        val competition = Competition(
                            jsonObject.get("id").toString().toInt(),
                            jsonObject.get("name").toString().drop(1).dropLast(1),
                            jsonObject.get("year").toString().toInt(),
                            jsonObject.get("champion").toString().drop(1).dropLast(1),
                            jsonObject.get("logo_url").toString().drop(1).dropLast(1)
                        )
                        competitions.addCompetition(competition)
                    }
                }
            }

        }
        return competitions
    }

}