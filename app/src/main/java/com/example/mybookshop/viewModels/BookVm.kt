package com.example.mybookshop.viewModels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mybookshop.model.Book
import com.example.mybookshop.model.getBooks

class BookVm : ViewModel() {
    private var _isbnError = MutableLiveData<Boolean>(true)
    var isbnError: LiveData<Boolean>
        get() = _isbnError
        set(value) { _isbnError.value = value.value }

    private var _titleError = MutableLiveData<Boolean>(true)
    var titleError: LiveData<Boolean>
        get() = _titleError
        set(value) { _titleError.value = value.value }

    private var _authorError = MutableLiveData<Boolean>(true)
    var authorError: LiveData<Boolean>
        get() = _authorError
        set(value) { _authorError.value = value.value }

    private var _publishYearError = MutableLiveData<Boolean>(true)
    var publishYearError: LiveData<Boolean>
        get() = _publishYearError
        set(value) { _publishYearError.value = value.value }

    private var _isAddButtonEnabled = MutableLiveData<Boolean>(false)
    var isAddButtonEnabled: LiveData<Boolean>
        get() = _isAddButtonEnabled
        set(value) { _isAddButtonEnabled.value = value.value }

    private val _bookList = getBooks().toMutableStateList()
    val bookList: List<Book>
        get() = _bookList

    fun createBook(book: Book){
        _bookList.add(book)
    }

    fun validateTitle(title: String) {
        TODO("Not yet implemented")
    }

    fun validateIsbn(isbn: String) {
        TODO("Not yet implemented")
    }

    fun validateAuthor(author: String) {
        TODO("Not yet implemented")
    }

    fun validateYear(publishYear: String) {
        TODO("Not yet implemented")
    }
}