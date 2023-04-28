package com.example.dataClass

data class ParentItem(val mList : MutableList<ChildData>,val list : MutableList<ChildData2>,val list2 :MutableList<VideoDataCls>? ,val textList :List<String>?)
data class UserItem(val mList : MutableList<String>)
data class CommentItem(val username :String,val caption :String)
