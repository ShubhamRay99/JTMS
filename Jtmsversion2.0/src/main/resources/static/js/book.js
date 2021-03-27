$(document)
		.ready(
				function() {
					var price, quant;
					var exp = /^[0-9]+$/;
					$("#book_name").change(function() {
						// alert(this.value);

						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/book/bookprice/" + this.value,
							dataType : 'json',
							cache : false,
							timeout : 600000,
							success : function(data) {
								price = data;
								quant = 1;
								$("#quantity").val(1);
								$("#price").val(getPrice(data, 1));

							},
							error : function(e) {
								console.log(e);
								$("#price").val('');
								$('#book_name').val('--select a book--')
								toastr.error('Please choose a book.');
							}
						});
					});
					$("#quantity")
							.keyup(
									function() {
										if ($.trim($('#book_name').val()) == '--select a book--'
												|| $
														.trim($('#book_name')
																.val()) == '') {
											$("#price").val('');
											toastr
													.error('Please choose a book.');

										} else if ($.trim($('#quantity').val()) == '') {
											$("#price").val('');
											toastr
													.error('Please choose book quantity.');
										} else if (!this.value.match(exp)) {
											this.value = this.value.replace(
													/[^0-9]/g, '');
											return false;
										} else {
											$("#price")
													.val(
															getPrice(price,
																	this.value));
										}
										// var num1=document.getElementById()

									});
				});
function getPrice(num1, num2) {
	return num1 * num2;
}