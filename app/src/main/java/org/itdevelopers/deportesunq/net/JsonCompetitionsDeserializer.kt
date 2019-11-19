package org.itdevelopers.deportesunq.net

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.itdevelopers.deportesunq.model.Competitions
import java.lang.reflect.Type

class JsonCompetitionsDeserializer: JsonDeserializer<Competitions> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Competitions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}