function studentModify() {
    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    var idModify;


    for (var i = 0; i < chekedChekboxes.length; i++) {
        if (chekedChekboxes[i].checked) {
            countChecked++;
            idModify = chekedChekboxes[i].value;
        }
    }
    if (countChecked == 0) {
        alert("Please, select student!!!");
        return;
    }

    if (countChecked > 1) {
        alert("Please, select only one student!!!");
        return;
    }

    document.getElementById('hiddenModifyId').value = idModify;
    document.getElementById('formToModify').submit();

}

function studentProgress() {
    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    var idStud;


    for (var i = 0; i < chekedChekboxes.length; i++) {
        if (chekedChekboxes[i].checked) {
            countChecked++;
            idStud = chekedChekboxes[i].value;
        }
    }
    if (countChecked == 0) {
        alert("Please, select student!!!");
        return;
    }

    if (countChecked > 1) {
        alert("Please, select only one student!!!");
        return;
    }

    document.getElementById('hiddenIdToProgress').value = idStud;
    document.getElementById('formToProgress').submit();

}

function studentDelete() {
    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    // сохранилась переменная > чем одна, 1 4 5
    var idsToDelete = "";


    for (var i = 0; i < chekedChekboxes.length; i++) {
        if (chekedChekboxes[i].checked) {
            countChecked++;
            idsToDelete = idsToDelete +chekedChekboxes[i].value + " ";
        }
    }
    if (countChecked == 0) {
        alert("Please, select student!!!");
        return;
    }

    document.getElementById('hiddenIdsToDelete').value = idsToDelete;
    document.getElementById('formToProgress').submit();

}

