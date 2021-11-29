<header class="bg-primary text-white" >
    <div class="title mx-4 d-flex flex-column">
        <h1 class="m-0">KAS Bulanan</h1>
        <p class="m-0">Sistem Informasi 5B</p>
    </div>
    <div class="dropdown">
        <button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="bi bi-person-workspace"></i>
            ${sessionScope.user.username}
        </button>
        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenuButton1">
            <li>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/logout.page">Logout</a>
            </li>
        </ul>
    </div>
</header>
<div class="side-nav bg-dark bg-gradient" >
    <ul class="nav flex-column fs-4">
        <li class="nav-item border-top ${home}"><a class="nav-link text-white" href="${pageContext.request.contextPath}/home.page"><i class="bi bi-house-door-fill me-2"></i>Home</a></li>
        <li class="nav-item border-top ${inkas}"><a class="nav-link text-white" href="${pageContext.request.contextPath}/inkas.page"><i class="bi bi-graph-up-arrow me-2"></i>Kas Masuk</a></li>
        <li class="nav-item border-top border-bottom ${outkas}"><a class="nav-link text-white" href="${pageContext.request.contextPath}/outkas.page"><i class="bi bi-graph-down-arrow me-2"></i>Kas Keluar</a></li>
    </ul>

</div>