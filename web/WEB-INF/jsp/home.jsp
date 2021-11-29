<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SI5B | KAS</title>
        <%@include file="/WEB-INF/jsp/style.jsp"%>
    </head>
    <body>
        <div class="app">
            <%@include file="/WEB-INF/jsp/headernav.jsp"%>
            <main class="px-4 py-2" >
                <%@include file="/WEB-INF/jsp/saldo.jsp"%>

                <div class="card">
                    <p class="card-header">Transaksi Kas Terakhir*</p>
                    <div class="card-body">
                        <h5 class="card-title">Kas Masuk</h5>
                        <a href="${pageContext.request.contextPath}/inkas.page" class="btn btn-primary">Halaman Kas Masuk</a>
                        <div class="mt-2">
                            <table class="table table-striped table-bordered">
                                <tr class="table-dark">
                                    <!--<th>No</th>-->
                                    <th>Kode</th>
                                    <th>Tanggal Masuk</th>
                                    <th>Keterangan</th>
                                    <th>Jumlah</th>
                                </tr>
                                <c:forEach items="${listKasMasuk}" var="kasMasuk">
                                    <tr>
                                        <!--<td>${kasMasuk.id}</td>-->
                                        <td>${kasMasuk.kode}</td>
                                        <td>${kasMasuk.tanggal}</td>
                                        <td>${kasMasuk.keterangan}</td>
                                        <td>Rp. ${kasMasuk.jumlah}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <h5 class="card-title">Kas Keluar</h5>
                        <a href="${pageContext.request.contextPath}/outkas.page" class="btn btn-primary">Halaman Kas Keluar</a>
                        <div class="mt-2">
                            <table class="table table-striped table-bordered">
                                <tr class="table-dark">
                                    <!--<th>No</th>-->
                                    <th>Kode</th>
                                    <th>Tanggal Keluar</th>
                                    <th>Keterangan</th>
                                    <th>Jumlah</th>
                                </tr>
                                <c:forEach items="${listKasKeluar}" var="kasKeluar">
                                    <tr>
                                        <!--<td>${kasKeluar.id}</td>-->
                                        <td>${kasKeluar.kode}</td>
                                        <td>${kasKeluar.tanggal}</td>
                                        <td>${kasKeluar.keterangan}</td>
                                        <td>Rp. ${kasKeluar.jumlah}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <p>*maksimal menampilkan 5 data</p>
                    </div>
                </div>              
            </main>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
