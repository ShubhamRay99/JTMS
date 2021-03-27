$(document)
		.ready(
				function() {
					$("#subjectCode")
							.change(
									function() {

										if ($.trim($('#subjectCode').val()) == '--select a subject--') { // not
																											// working
											$("#batchid").val(
													'--Select A Batch--');
											$("#fee").val('Course Price');
										}

										$
												.ajax({
													type : "POST",
													contentType : "application/json",
													url : "/StudentCourseDetails/viewSubjectFee/"
															+ this.value,
													dataType : 'json',
													cache : false,
													timeout : 600000,
													success : function(data) {
														$("#fee").val(data);
													},
													error : function(e) {
														console.log(e);
													}
												});

										$
												.ajax({
													type : "POST",
													contentType : "application/json",
													url : "/StudentCourseDetails/viewBatches/"
															+ this.value,
													dataType : 'json',
													cache : false,
													timeout : 600000,
													success : function(data) {
														List = data;
														$('#batchid').empty();
														$('#batchid')
																.append(
																		'<option value="">--select a batch--</option>');
														for (i in List) {
															$('#batchid')
																	.append(
																			'<option value="'
																					+ List[i].batchName
																					+ '">'
																					+ List[i].batchName
																					+ ' From '
																					+ List[i].arrival_timing
																					+ " to "
																					+ List[i].departure_timing
																					+ '</option>');
														}
													},
													error : function(e) {
														console.log(e);
													}
												});

									});
				});

//-----------------------------------------------------------------jtian 
$(document)
.ready(
		function() {
			$("#subjectCode")
			.change(
					function() {
						
						if ($.trim($('#subjectCode').val()) == '--select a subject--') { // not
							// working
							$("#batchid").val(
							'--Select A Batch--');
							$("#fee").val('Course Price');
						}
						
						$
						.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/JtianCourseDetails/viewSubjectFee/"
								+ this.value,
								dataType : 'json',
								cache : false,
								timeout : 600000,
								success : function(data) {
									$("#fee").val(data);
								},
								error : function(e) {
									console.log(e);
								}
						});
						
						$
						.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/JtianCourseDetails/viewBatches/"
								+ this.value,
								dataType : 'json',
								cache : false,
								timeout : 600000,
								success : function(data) {
									List = data;
									$('#batchNames').empty();
									$('#batchNames')
									.append(
									'<option value="">--select a batch--</option>');
									for (i in List) {
										$('#batchNames')
										.append(
												'<option value="'
												+ List[i].batchName
												+ '">'
												+ List[i].batchName
												+ ' From '
												+ List[i].arrival_timing
												+ " to "
												+ List[i].departure_timing
												+ '</option>');
									}
								},
								error : function(e) {
									console.log(e);
								}
						});
						
					});
		});
