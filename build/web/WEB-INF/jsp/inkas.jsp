<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SI5B | Kas Masuk</title>
        <%@include file="/WEB-INF/jsp/style.jsp"%>
    </head>
    <body>
        <div class="app">
            <%@include file="/WEB-INF/jsp/headernav.jsp"%>
            <main class="px-4 py-2">
                <%@include file="/WEB-INF/jsp/saldo.jsp"%>

                <div class="card">
                    <p class="card-header">List Semua Transaksi</p>
                    <div class="card-body">
                        <h5 class="card-title">Kas Masuk</h5>
                        <a href="${pageContext.request.contextPath}/inkas/form.page" class="btn btn-primary">Entry Kas Masuk</a>
                        <div class="mt-2">
                            <table class="table table-striped table-bordered align-middle">
                                <tr class="table-dark">
                                    <th>Id</th>
                                    <th>Kode</th>
                                    <th>Tanggal Masuk</th>
                                    <th>Keterangan</th>
                                    <th>Jumlah</th>
                                    <th style="width: 10rem;">Aksi</th>
                                </tr>
                                <c:forEach items="${listKasMasuk}" var="kasMasuk">
                                    <tr>
                                        <td>${kasMasuk.id}</td>
                                        <td>${kasMasuk.kode}</td>
                                        <td>${kasMasuk.tanggal}</td>
                                        <td>${kasMasuk.keterangan}</td>
                                        <td>Rp. ${kasMasuk.jumlah}</td>
                                        <td>
                                            <button class="btn btn-warning" onclick="window.location.href = 'inkas/form.page?action=edit&id=${kasMasuk.id}'">
                                                Edit
                                            </button>
                                            <button class="btn btn-danger" onclick="window.location.href = 'inkas/form.page?action=delete&id=${kasMasuk.id}'">
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
