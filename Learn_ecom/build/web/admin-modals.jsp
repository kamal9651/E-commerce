
<%@page import="com.ecom.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ecom.helper.ConnectionProvider"%>
<%@page import="com.ecom.dao.CategoryDao"%>
<!-- Admin profile Modal -->
<div class="modal jackInTheBox animated" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">


    <div class="modal-dialog modal-lg" role="document">



        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><%= user.getuName()%></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h1><%= user.getuEmail()%></h1>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<!-- Add Category Modal -->
<div class="modal jackInTheBox animated" id="add-catergory-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">


    <div class="modal-dialog modal-sm " role="document">


        <form action="CatOperations" method="post">
            <div class="modal-content bg-dark">
                <div class="modal-header ">
                    <h5 class="modal-title text-white" id="exampleModalLabel">Add Category</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="text-white" aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <input type="text" name="cat_name" placeholder="Enter catergory name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <textarea class="form-control" name="cat_desc" placeholder="Enter your catergory description"></textarea>  

                    </div>

                    <input type="hidden" value="add_cat" name="operation" />



                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-light btn-block">Save changes</button>
                </div>
            </div>

        </form>
    </div>
</div>


<!--Add product modal-->

<div class="modal fadeIn animated" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">


    <div class="modal-dialog modal-sm " role="document">


        <form action="ProductServet" enctype="multipart/form-data" method="post">
            <div class="modal-content bg-secondary">
                <div class="modal-header ">
                    <h5 class="modal-title text-white" id="exampleModalLabel">Add Product</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="text-white" aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <input type="text" name="p_name" placeholder="Enter product name" class="form-control" />
                    </div>


                    <div class="form-group">
                        <textarea class="form-control" name="p_desc" placeholder="Enter your product description"></textarea>  

                    </div>


                    <div class="form-group">
                        <input type="number" name="p_price" placeholder="Enter product price" class="form-control" />
                    </div>
                    <div class="form-group">
                        <input type="number" name="p_quantity" placeholder="Enter product quantity" class="form-control" />
                    </div>

                    <div class="form-group">
                        <input type="file" name="p_pic"  class="form-control" />
                    </div>
                    <div class="form-group">
                        <input type="number" name="p_discount" placeholder="Enter discount in %"  class="form-control" />
                    </div>
                    <div class="form-group">

                        <%
                            CategoryDao dao = new CategoryDao(ConnectionProvider.createConnection());
                            ArrayList<Category> list = dao.getAllCategories();

                        %>

                        <select name="p_cat" class="form-control">
                            <%                               for (Category cat : list) {
                            %>

                            <option value="<%= cat.getcId()%>"><%= cat.getcName()%></option>

                            <%}%>
                        </select>

                    </div>






                    <input type="hidden" value="add_product" name="operation" />



                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-light btn-block">Save changes</button>
                </div>
            </div>

        </form>
    </div>
</div>

