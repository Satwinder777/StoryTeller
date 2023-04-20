package com.example.dataClass

data class ParentItem(val mList : MutableList<ChildData>,val list : MutableList<ChildData2>)
data class UserItem(val mList : MutableList<String>)
data class CommentItem(val username :String,val caption :String)
