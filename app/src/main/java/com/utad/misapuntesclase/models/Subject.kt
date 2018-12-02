package io.github.alvarosanzrodrigo.fragmentlisttask3.Models

import android.graphics.drawable.Drawable
//Well, this is an object.
class Subject(
    var imageID: Int,
    var name: String,
    var description: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>?
)