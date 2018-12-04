package com.utad.misapuntesclase.db

import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.modelsEntity.*
import java.util.*
import kotlin.collections.ArrayList


// todo: do it

//     ClassroomSubjects
var menuSYSPSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuINTDSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuDATASubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuPSPRSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuEMSGSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuTIGSSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuCWRFSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)
var menuPDAMSubject: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("13", "Number of Alumns"),
    RecyclerViewData("Random teacher", "Teacher"),
    RecyclerViewData("7", "Total average grade"),
    RecyclerViewData("9.9", "My average grade"),
    RecyclerViewData("3", "Ranking")
)

    var defClassroomData: List<Subject> = listOf(
        Subject(R.drawable.ic_, "Services And Processes Programming", "Processes and threats", menuSYSPSubject),
        Subject(R.drawable.ic_interfaces, "Interfaces", "You are suppose to learn interfaces here but we do Android",menuINTDSubject),
        Subject(R.drawable.ic_data_access, "Database Access", "Yo will die here", menuDATASubject),
        Subject(R.drawable.ic_mobile_development, "Mobile Programming", "We learn iOs here", menuPSPRSubject),
        Subject(R.drawable.ic_sgem, "Enterprise Administration Systems", "I don't know what is this about", menuEMSGSubject),
        Subject(R.drawable.ic_english, "English", "Technical English for programmers", menuTIGSSubject),
        Subject(R.drawable.ic_work_center, "Work Center Formation", "Formation in a external center", menuCWRFSubject),
        Subject(R.drawable.ic_idea, "Final Project", "Final work where you demonstrate what you learn",menuPDAMSubject )
    )


//community
var menuProgrammingCommunity: ArrayList<RecyclerViewData> = arrayListOf(RecyclerViewData("23", "Number of alums"),
    RecyclerViewData("M107", "Classroom"),
    RecyclerViewData("Contest 1", "Eventos"),
    RecyclerViewData("U-tad Manager", "Current Project"),
    RecyclerViewData("9.9", "Rating")
)
var menuMobileCommunity: ArrayList<RecyclerViewData> = arrayListOf(RecyclerViewData("23", "Number of alums"),
    RecyclerViewData("M107", "Classroom"),
    RecyclerViewData("Contest 1", "Eventos"),
    RecyclerViewData("U-tad Manager", "Current Project"),
    RecyclerViewData("9.9", "Rating")
)
var menuVRCommunity: ArrayList<RecyclerViewData> = arrayListOf(RecyclerViewData("23", "Number of alums"),
    RecyclerViewData("M107", "Classroom"),
    RecyclerViewData("Contest 1", "Eventos"),
    RecyclerViewData("U-tad Manager", "Current Project"),
    RecyclerViewData("9.9", "Rating")
)
var menuVideogamesCommunity: ArrayList<RecyclerViewData> = arrayListOf(RecyclerViewData("23", "Number of alums"),
    RecyclerViewData("M107", "Classroom"),
    RecyclerViewData("Contest 1", "Eventos"),
    RecyclerViewData("U-tad Manager", "Current Project"),
    RecyclerViewData("9.9", "Rating")
)

    var defCommunityData: List<Community> = listOf(
        Community("Programming", R.drawable.ic_interfaces,
        "A community for programming in general, what ever you want to learn you can do it here.", "Daniel The Tall One", menuProgrammingCommunity),

        Community("Mobile",
            R.drawable.ic_mobile_development, "A community for Android and iOs, what ever you want to learn you can do it here.", "Daniel The Tall One", menuMobileCommunity),

        Community("Virtual Reality",
            R.drawable.ic_virtual_reality, "A community for virtual reality programming , what ever you want to learn you can do it here.", "Daniel The Tall One", menuVRCommunity),

        Community("Videogames",
            R.drawable.ic_videogames, "A community for programming videogames, and games discussing, what ever you want to learn you can do it here.", "Daniel The Tall One", menuVideogamesCommunity)
        )

//grades
    var defGradesData: List<Grades> = listOf(
        Grades("6", Date(), "SYSP", "Task 3"),
        Grades("3.5", Date(), "ADAT", "Task 3"),
        Grades("8.2", Date(), "SYSP", "Task 3"),
        Grades("0.1", Date(), "TIGS", "Task 3"),
        Grades("5", Date(), "EMSG", "Task 3")
    )

// Notification
    var defNotificationData: List<Notifications> = listOf(
        Notifications("Pepe", Date(), "SYSP"),
        Notifications("Julio", Date(), "ADAT"),
        Notifications("Almudena", Date(), "EMSG"),
        Notifications("Gustavo", Date(), "PSPR"),
        Notifications("Silvia", Date(), "EMSG"),
        Notifications("Ana", Date(), "ADAT")
    )

// Teachers
var menuDavidTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)
var menuPedroTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)
var menuJaimeTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)
var menuCarlosTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)
var menuLauraTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)
var menuMeritxelTeacher: ArrayList<RecyclerViewData> = arrayListOf(
    RecyclerViewData("asignatura 1", "3 horas"),
    RecyclerViewData("asignatura 2", "2 horas"),
    RecyclerViewData("asignatura 4", "5 horas")
)

    var defTeacherData: List<Teacher> = listOf(
        Teacher(R.mipmap.profile_pic_teacher_1_round, "David", "Jardon Peinado", menuDavidTeacher),
        Teacher(R.mipmap.profile_pic_teacher_2_round, "Pedro", "Camacho", menuPedroTeacher),
        Teacher(R.mipmap.profile_pic_teacher_4_round, "Jaime", "Lannister", menuJaimeTeacher),
        Teacher(R.mipmap.profile_pic_teacher_5_round, "Carlos", "El de iOs", menuCarlosTeacher),
        Teacher(R.mipmap.profile_pic_teacher_6_round, "Laura", "Nose", menuLauraTeacher),
        Teacher(R.mipmap.profile_pic_teacher_7_round, "Meritxel", "La de fol", menuMeritxelTeacher)
    )



