<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
  <title>JohnToan</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="jumbotron text-center">
  <h1>Xin chào đến với trang web của tôi!</h1>
</div>

 <div class="container">
 <a href="/sanpham/admin">Quay lại</a>
  <h2>Sản phẩm: ${product.tensanpham}</h2>
  <p>the image product:</p>            
  <img src="/images/${product.hinhanh}" class="img-thumbnail" alt="Cinque Terre" width="304" height="236"/> 
  <br>
  <br>
  
  Giá bán : ${product.giaban} <br>
  Giá Nhâp : ${product.gianhap} <br>
  Mô tả sản phẩm : ${product.motasanpham} <br>
  Ngày Nhập kho : ${product.ngaynhapkho} <br>
  Trạng thái : ${product.trangthai}
</div>

<div class="jumbotron text-center">
  <h1>Xin chào đến với trang web của tôi!</h1>
</div>
</body>
</html>
