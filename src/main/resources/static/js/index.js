// 주문 데이터 테이블 표시 함수 -s-
function appendTag(val){
    let orderTbody = $("#orderTbody");
    orderTbody.empty();

    // 데이터 없을 경우
    if(val == ""){
        orderTbody.append(`
            <tr>
                <td colspan="4">주문 목록이 없습니다</td>
            </tr>`);
    }

    val.forEach(e => {
        let row =`
            <tr>
                <td>${e.orderId}</td>
                <td>${e.orderName}</td>
                <td>${e.orderDate}</td>
                <td>${e.orderType}</td>
            </tr>`;

        orderTbody.append(row);
    });
}
// 주문 데이터 테이블 표시 함수 -e-

// 새로고침 -s-
function reloadBtn(){
    $.ajax({
        url: "./api/order/get",
        type: "GET",
        success: function(val) {
            appendTag(val);
        },
        error: function(e) {
            alert("데이터를 불러오는 데 실패했습니다.");
        }
    })
}
// 새로고침 -e-

// 주문ID 검색 -s-
function searchId(){
    let searchText = $("#searchText").val();

    $.ajax({
        url: "./api/order/getSearchId",
        data: {
            id : searchText
        },
        type: "GET",
        success: function(val) {
            appendTag(val);
        },
        error: function(e) {
            alert("데이터를 불러오는 데 실패했습니다.");
        }
    })
    
}
// 주문ID 검색 -e-

// 외부시스템에 데이터 전송 -s-
function dateSend(){

    $.ajax({
        url: "api/order/getset",
        type: "GET",
        success: function(val) {
            console.log(val);
        },
        error: function(e) {
            $("#result").text("데이터를 불러오는 데 실패했습니다.");
        }
    })

}
// 외부시스템에 데이터 전송 -e-