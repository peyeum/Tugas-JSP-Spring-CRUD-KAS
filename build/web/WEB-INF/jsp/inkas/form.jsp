<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Kas Masuk</title>
        <%@include file="/WEB-INF/jsp/style.jsp"%>
    </head>
    <body>
        <div id="particles-js">
            <div class="custom-form p-4 rounded-3 shadow bg-light">
                <h1>Form ${act} Kas Masuk</h1>
                <form action="${pageContext.request.contextPath}/inkas/form.page" modelAttribute="kasin" method="POST" >
                    <span class="form-floating">
                        <input class="form-control" type="text" id="kode" name="kode" placeholder="Kode" value="${kasMasuk.kode}" ${act == "Edit" ? "readonly" : ""}>
                        <label for="kode">Kode</label>
                    </span>
                    <span class="form-floating">
                        <input class="form-control" type="date" id="tanggal" name="tanggal" value="${kasMasuk.tanggal != null ? kasMasuk.tanggal : date}">
                        <label for="tanggal">Tanggal</label>
                    </span>
                    <span class="form-floating">
                        <input class="form-control" type="text" id="keterangan" name="keterangan" placeholder="keterangan" value="${kasMasuk.keterangan}">
                        <label for="keterangan">Keterangan</label>
                    </span>
                    <span class="form-floating">
                        <input class="form-control" type="number" id="jumlah" name="jumlah" placeholder="Jumlah" value="${kasMasuk.jumlah}">
                        <label for="jumlah">Jumlah</label>
                    </span>
                    <input type="hidden" name="id" value="${kasMasuk.id != null ? kasMasuk.id : 0}">
                    <input class="w-100 mt-3 btn btn-primary" type="submit" value="Simpan">
                </form>
                <a class="w-100 mt-2 btn btn-warning" href="${pageContext.request.contextPath}/inkas.page">back</a>
            </div>
        </div>

        <%@include file="/WEB-INF/jsp/particles.jsp"%>
    </body>
</html>
