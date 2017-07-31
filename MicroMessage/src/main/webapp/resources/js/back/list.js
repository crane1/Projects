function deleteOne(id){
	$("#mainForm").attr("action","deleteOne.action?id="+id)
	$("#mainForm").submit()
}

function deleteBatch(){
	$("#mainForm").attr("action","deleteBatch.action")
	$("#mainForm").submit()
}

function UpdateOne(id){
	$("#mainForm").attr("action","updateOne.action?id=" + id)
	$("#mainForm").submit()
}

function InsertOne(){
	$("#mainForm").attr("action","insert.action")
	$("#mainForm").submit()
}