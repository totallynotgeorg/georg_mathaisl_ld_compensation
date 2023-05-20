package com.example.mybookshop.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Book(
    var isbn: String,
    var title: String,
    var author: String,
    var publishYear: String,
    var coverImage: String
)

fun getBooks(): List<Book> {
    val json =
        """[{"isbn":"511937416-6","title":"Seducing Doctor Lewis (Grande séduction, La)","author":"Dario Paxman","publishYear":2012,"coverImage":"http://dummyimage.com/106x100.png/dddddd/000000"},
{"isbn":"627187777-X","title":"John Huston: The Man, the Movies, the Maverick","author":"Christoph Squibe","publishYear":1992,"coverImage":"http://dummyimage.com/245x100.png/ff4444/ffffff"},
{"isbn":"134980488-6","title":"Young Lieutenant, The (Le petit lieutenant)","author":"Farrel Grimstead","publishYear":1994,"coverImage":"http://dummyimage.com/163x100.png/ff4444/ffffff"},
{"isbn":"280358102-7","title":"Kings of the Road (Im Lauf der Zeit)","author":"Ericka Arnaut","publishYear":1992,"coverImage":"http://dummyimage.com/193x100.png/cc0000/ffffff"},
{"isbn":"107579493-5","title":"Children of the Night","author":"Glynda Iacobo","publishYear":1996,"coverImage":"http://dummyimage.com/142x100.png/cc0000/ffffff"},
{"isbn":"259964351-1","title":"Death Wish","author":"Milli Shirtliff","publishYear":2007,"coverImage":"http://dummyimage.com/235x100.png/5fa2dd/ffffff"},
{"isbn":"650285000-6","title":"She's Having a Baby","author":"Winslow Leagas","publishYear":1995,"coverImage":"http://dummyimage.com/178x100.png/dddddd/000000"},
{"isbn":"684852684-3","title":"Relentless","author":"Tybie Iaduccelli","publishYear":1996,"coverImage":"http://dummyimage.com/221x100.png/5fa2dd/ffffff"},
{"isbn":"772380956-5","title":"Palme","author":"Hildy Ambrosch","publishYear":1993,"coverImage":"http://dummyimage.com/120x100.png/cc0000/ffffff"},
{"isbn":"858272494-2","title":"Ernest Scared Stupid","author":"Giacobo Haggidon","publishYear":2008,"coverImage":"http://dummyimage.com/132x100.png/cc0000/ffffff"},
{"isbn":"795255336-4","title":"Gregory Crewdson: Brief Encounters","author":"Hilary Vickar","publishYear":1989,"coverImage":"http://dummyimage.com/189x100.png/cc0000/ffffff"},
{"isbn":"734760936-4","title":"112 Weddings","author":"Fernandina Tarn","publishYear":2004,"coverImage":"http://dummyimage.com/171x100.png/5fa2dd/ffffff"},
{"isbn":"046662071-3","title":"Purple Noon (Plein soleil)","author":"Tildi Kroon","publishYear":2001,"coverImage":"http://dummyimage.com/127x100.png/ff4444/ffffff"},
{"isbn":"541224643-5","title":"Rockaway","author":"Lurlene Lockhead","publishYear":1999,"coverImage":"http://dummyimage.com/187x100.png/ff4444/ffffff"},
{"isbn":"515882785-0","title":"Paper Planes","author":"Pascal Rodman","publishYear":1997,"coverImage":"http://dummyimage.com/238x100.png/cc0000/ffffff"},
{"isbn":"536469854-8","title":"Kozara","author":"Nelli Picot","publishYear":1999,"coverImage":"http://dummyimage.com/158x100.png/5fa2dd/ffffff"},
{"isbn":"240726792-3","title":"Tuesdays with Morrie","author":"Kimmie Tripcony","publishYear":2006,"coverImage":"http://dummyimage.com/167x100.png/5fa2dd/ffffff"},
{"isbn":"432797487-0","title":"In Fear","author":"Jay Shapcote","publishYear":2004,"coverImage":"http://dummyimage.com/143x100.png/5fa2dd/ffffff"},
{"isbn":"697923824-8","title":"This Is Where I Leave You","author":"Clarke Reven","publishYear":1992,"coverImage":"http://dummyimage.com/226x100.png/cc0000/ffffff"},
{"isbn":"641044623-3","title":"City of Hope","author":"Cletis Paramore","publishYear":2001,"coverImage":"http://dummyimage.com/100x100.png/dddddd/000000"}]"""
    val typeToken = object : TypeToken<List<Book>>() {}.type
    val books = Gson().fromJson<List<Book>>(json, typeToken)
    return books
}
