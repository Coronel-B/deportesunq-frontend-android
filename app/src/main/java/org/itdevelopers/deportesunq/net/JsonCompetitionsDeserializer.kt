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
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Competitions? {
        val competitions: Competitions? = null
        if (json?.isJsonObject!!) {
            for (entry in json.asJsonObject.entrySet()) {
                if (entry.key == "status") {
                    Log.d("Test", "Primitive: " + entry.key.toString() + entry.value.asString)
                    competitions?.setStatus(entry.value.asString)
                } else if (entry.key == "message") {
                    Log.d("Test", "Object: key: " + entry.key.toString() + " = "+ entry.value)
                    val jsonObject: JsonObject = entry.value.asJsonObject
                    for (subEntry in jsonObject.entrySet()) {
//                        TODO: Llenar cada competición
//                        val competition = Competition(subEntry.key[''],)
                        val competition = Competition()
                        competitions?.addCompetition(competition)
                    }
                }
            }

        }
        return competitions
    }

}