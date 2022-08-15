package org.techtown.textrecognitionapp2

// 순번, 식품명, 유통기한 값을 한 번에 담을 수 있는 data class 선언

data class InformationData(
    private var no: Int? = null, //no
    private var title: String? = null, //식품명
    private var date: String? = null) { //유통기한

    fun getNo(): Int? { return no } //no를 가져오는 함수
    fun getTitle(): String? { return title } //식품명을 가져오는 함수
    fun getDate(): String? { return date } //유통기한을 가져오는 함수
    fun setNo(no: Int) { this.no = no } //no를 설정하는 함수
    fun setTitle(title: String) { this.title = title } //식품명을 설정하는 함수
    fun setDate(date: String) { this.date = date } //유통기한을 설정하는 함수
}


