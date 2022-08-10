package org.techtown.textrecognitionapp2

data class InformationData(
    private var no: Int? = null,
    private var title: String? = null,
    private var date: String? = null) {

    fun getNo(): Int? { return no }
    fun getTitle(): String? { return title }
    fun getDate(): String? { return date }
    fun setNo(no: Int) { this.no = no }
    fun setTitle(title: String) { this.title = title }
    fun setDate(date: String) { this.date = date }
}


