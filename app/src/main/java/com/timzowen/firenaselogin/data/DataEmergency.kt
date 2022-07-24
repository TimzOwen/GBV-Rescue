package com.timzowen.idoctor.data

import com.timzowen.idoctor.model.EmergencyNumbers

class DataEmergency {

    fun loadCalls(): List<EmergencyNumbers> {
        return listOf(
            EmergencyNumbers("Nairobi County", "Kijabe Hosp", "0702020202"),
            EmergencyNumbers("Nakuru County", "Kabarak Hosp", "0703030303"),
            EmergencyNumbers("Baringo County", "Mercy Hosp", "0704040404"),
            EmergencyNumbers("Mombasa County", "Mediheal Hosp", "0705050505"),
            EmergencyNumbers("Nairobi County", "Kijabe", "0706060606"),
            EmergencyNumbers("Mombasa County", "Kibaki", "0707070707"),
            EmergencyNumbers("Turkana County", "Mwanga Hosp", "0708080808"),
            EmergencyNumbers("Bomet County", "Whales Hosp", "0709090909"),
            EmergencyNumbers("Nairobi County", "Kijabe Hosp", "0710101010"),
            EmergencyNumbers("Nakuru County", "Kabarak Hosp", "0711111111"),
            EmergencyNumbers("Baringo County", "Mercy Hosp", "0712121212"),
            EmergencyNumbers("Mombasa County", "Mediheal Hosp", "0713131313"),
            EmergencyNumbers("Nairobi County", "Kijabe", "0714141414"),
            EmergencyNumbers("Mombasa County", "Kibaki", "0715151515"),
            EmergencyNumbers("Turkana County", "Mwanga Hosp", "071616161"),
            EmergencyNumbers("Bomet County", "Whales Hosp", "0717171717")
        )
    }

}