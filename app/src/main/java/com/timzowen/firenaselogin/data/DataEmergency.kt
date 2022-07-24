package com.timzowen.idoctor.data

import com.timzowen.idoctor.model.EmergencyNumbers

class DataEmergency {

    fun loadCalls(): List<EmergencyNumbers> {
        return listOf(
            EmergencyNumbers("Nairobi County", "Kijabe Hosp", "0702020202"),
            EmergencyNumbers("Nakuru County", "Kabarak Hosp", "0703030303"),
            EmergencyNumbers("kisumu County", "Mercy Hosp", "0704040404"),
            EmergencyNumbers("Mombasa County", "Mediheal Hosp", "0705050505"),
            EmergencyNumbers("Nakuru County", "PGH Nakuru", "0706060606"),
            EmergencyNumbers("Nakuru County", "Mogotio SCH", "0707070707"),
            EmergencyNumbers("Baringo County", "Kabarnet CRH ", "0708080808"),
            EmergencyNumbers("Nairobi County", "KU CRH ", "0709090909"),
            EmergencyNumbers("Nairobi County", "Keringet SCH", "0710101010"),
            EmergencyNumbers("Nakuru County", "Molo Hosp", "0711111111"),
            EmergencyNumbers("Eldoret County", "Moi Refferal", "0712121212"),
            EmergencyNumbers("UasinG County", "Eldoret District", "0713131313"),
            EmergencyNumbers("Nakuru County", "Mirugi SCH", "0714141414"),
            EmergencyNumbers("Kericho County", "Bliss HOSP", "0715151515"),
            EmergencyNumbers("Nairobi County", "Nairobi Hosp", "071616161"),
            EmergencyNumbers("Nairobi County", "Nairobi Womens", "0717171717")
        )
    }

}