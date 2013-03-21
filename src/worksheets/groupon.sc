package worksheets

object groupon {
  val file = io.Source.fromFile("c:/groupon.html")//> file  : scala.io.BufferedSource = non-empty iterator
  val text = file mkString                        //> text  : String = <head>
                                                  //| <script type="text/javascript">var NREUMQ=[];NREUMQ.push(["mark","firstbyte"
                                                  //| ,new Date().getTime()])</script>
                                                  //| <title>Groupon Shopping</title>
                                                  //| <meta name="title" content="Groupon Shopping"/>
                                                  //| <meta name="description" content="Find deals in your city the new way with G
                                                  //| roupon vouchers. Our deals offer discounts up to 70% on spa, cinema, travel 
                                                  //| and more! Sign up now for a new deal every day!"/>
                                                  //| <meta name="keywords" content="Shopping, electronics, home, furniture, print
                                                  //| , groupon, voucher, deal, discount"/>
                                                  //| <link rel="canonical" href="index"/>
                                                  //| <link rel="alternate"
                                                  //|           type="application/rss+xml"
                                                  //|           title="RSS-News"
                                                  //|           href="http://api.groupon.de/feed/api/v1/deals/oftheday/ZA/national
                                                  //| -deals"/>
                                                  //| <meta name="viewport" content="max-scale=1.0, user-scalable=yes"/>
                                                  //| <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                                                  //| <link rel="stylesheet" type="text/css" media="all" href="http://sites.sehirf
                                                  //| irsati.com/int/hubs/bundles/layout_bundle.css" />
                                                  //| <script type="text/javascript" src="http://sites.sehirfirsati.com/int/hubs/b
                                                  //| undles/general_bundle.js" ></script>
                                                  //| <script src="http://sites.sehirfirsati.com/int/hubs/js/jqCycle.js"></script>
                                                  //| 
                                                  //| <script>
                                                  //| 
                                                  //| $(document).ready(function(){
                                                  //| 	$('#hub_featuredSliderDealList').cycle({ 
                                                  //|     fx:     'fade', 
                                                  //|     speed:   300, 
                                                  //|     timeout: 3000, 
                                                  //|     pager:  '#hub_featuredSliderNav',
                                                  //|     pause:   1 
                                                  //| });
                                                  //| 	$(".hub_dealDetails").animate({ 
                                                  //| 	  opacity: "0"
                                                  //| 	  }, "fast");
                                                  //| 	$(".hub_categoryDeal").hover(function(){
                                                  //| 	  $(".hub_dealDetails", this).animate({ 
                                                  //| 	  	opacity: "1"
                                                  //| 	  	}, "fast");
                                                  //| 	},
                                                  //| 	function(){
                                                  //| 	  $(".hub_dealDetails", this).animate({ 
                                                  //| 	  opacity: "0"
                                                  //| 	  }, "fast");
                                                  //| 	});
                                                  //| 	$('#hub_categorySelector a').click(function() {
                                                  //|     // fetch the class of the clicked 
                                                  //| Output exceeds cutoff limit.
  
  def grouponDeals(text: String) = {
  	val headless = text substring(text.indexOf("</head>")+"</head>".length)
  
	  val escaped = (headless replaceAll ("&","&amp;")) replaceAll ("</html>","")
	  
	  import xml._
	  
	  val data = XML.loadString("<root>\n"+escaped+"\n</root>")
	  
	  
	  
	  val divs = data \\ "body" \ "div"
	  val wrapall = divs head
	  val content = wrapall \"div" toList(3)
	  
	  val slider = content \ "div" \ "div" \"div" toList(1)
	  
	  val deals = slider \ "div" \ "div" toList
	  
	  def extractDeals(deal: Node) = {
			  val href = deal \ "div" \ "a" \ "@href" text
			  val img = deal \ "div" \ "a" \ "img" \ "@src" text
				val desc = (deal \ "h2" \ "a").text
			  val price = ((((deal \ "div" toList(1)) \ "div") toList) last) text
			  
			  (href, img, desc, price)
	  }
	  
	  for(d <- deals) yield extractDeals(d)
  }                                               //> grouponDeals: (text: String)List[(String, String, String, String)]

  file close
  
  for(r <- grouponDeals(text)){
  	print(r._1+"||"+r._2+"||"+r._3+"||"+r._4+"\n")
                                                  //> http://www.groupon.ae/deals/national-deal/Nestle-Middle-East-FZE/18825923?u
                                                  //| tm_source=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-conten
                                                  //| t.net/34/40/1362978954034.png||Say "Groupon Birthday Exclusive!" with a NES
                                                  //| CAFÉ® Dolce Gusto® PICCOLO|| AED30
                                                  //| http://www.groupon.ae/deals/national-deal/Sports-Gallery-LLC/18134060?utm_s
                                                  //| ource=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-content.ne
                                                  //| t/85/30/1359357063085.png||Get fit with Motorized Treadmills from Sports Ga
                                                  //| llery|| AED1250
                                                  //| http://www.groupon.ae/deals/national-deal/Booming-Prosper-Limited/19160941?
                                                  //| utm_source=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-conte
                                                  //| nt.net/33/57/1354942475733.png||Colourful Bag Organizers|| AED65
                                                  //| http://www.groupon.ae/deals/national-deal/Mynd-Marketing/18689277?utm_sourc
                                                  //| e=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-content.net/36
                                                  //| /21/1362652112136.png||Take home a Vintage Style Round Table with Drawer|| 
                                                  //| AED299
                                                  //| http://www.groupon.ae/deals/national-deal/Groupon-Direct-113331/19137069?ut
                                                  //| m_source=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-content
                                                  //| .net/76/76/1363501987676.jpg||Prepare meals like a pro with the Ninja Maste
                                                  //| r Prep Food Processor|| AED189
                                                  //| http://www.groupon.ae/deals/national-deal/Groupon-Direct-199764/18132818?ut
                                                  //| m_source=GRPN&utm_medium=ShoppingFeatured||http://static.ae.groupon-content
                                                  //| .net/93/25/1361695952593.png||Authentic Emporio Armani Watches for men & wo
                                                  //| men|| AED699
  }
}