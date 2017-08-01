function deleteOne(id){
	$("#mainForm").attr("action","deleteOne.action?id="+id)
	$("#mainForm").submit()
}

function deleteBatch(){
	$("#mainForm").attr("action","deleteBatch.action")
	$("#mainForm").submit()
}

function UpdateOne(id){
	$("#mainForm").attr("action","updateOneCommod.action?id=" + id)
	$("#mainForm").submit()
}

function InsertOne(){
	$("#mainForm").attr("action","insertOneCommod.action")
	$("#mainForm").submit()
}

function InserContextOne(id){
	$("#mainForm").attr("action","insertOneContext.action?commodId=" + id)
	$("#mainForm").submit()
}

function LinkInsertContext(id){
	$("#mainForm").attr("action","alink.action?page=insertContext&id=" + id)
	$("#mainForm").submit()
}