# SweetDialog

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
<pre><b>
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 </b></pre>
  
 Step 2. Add the dependency
 <pre><b>
 dependencies {
	        implementation 'com.github.VikramSN:SweetDialog:Tag'
	}
</b>
</pre>
<pre>
<b>Utilization of library
=======================
</b>
 
 <b style='color:red'>SOME IMPORTANT POINTS.</b>
 
  <b>Property                        Value                                 Type</b>
  Title                           Anything/null                         String
  Message                         Anything/null                         String
  Cancelable                      true/false                            Boolean
  Icon                            R.drawable.youricon/0                 Drawable
  PositiveButtonText              Anything/null                         String
  NegativeButtonText              Anything/null                         String
  NeutralButtonText               Anything/null                         String
  listData                        Anything/null                         Array<String>
  boolListData                    Anything/null                         Array<Boolean>
  OnClick                         object:Interface{}                    Interface
  itemOnClick                     object:Interface{}                    Interface
  
</pre>
<b>Simple Alert with Single Button</b>
-------------------------------
<pre>
<b>SweetDialog.alertOne(Context,Title,Message,Icon,setCancelable,ButtonText,OnClick)</b>

<b>Example</b>
<i>SweetDialog.alertOne(this,"Title","Message",0,false,"Ok",object:DialogAction{
  	override fun singleAction(dialog: DialogInterface, position: Int) {
          	Do your work for Ok Button
       }

})</i>
</pre>

<b>Simple Alert with Two Button</b>
----------------------------
<pre>
<b>SweetDialog.alertTwo(Context,Title,Message,Icon,setCancelable,PositiveButtonText,NegativeButtonText,OnClick)</b>

<b>Example</b>
<i>SweetDialog.alertTwo(this,"Title","Message",0,false,"Ok","Cancel",object : DialogActionTwo {
    	override fun positiveAction(dialog: DialogInterface, position: Int) {
		Do your work for Positive Button
    }

   override fun negativeAction(dialog: DialogInterface, position: Int) {
       	Do your work for Negative Button
    }
}</i>
</pre>

<b>Simple Alert with Three Button</b>
--------------------------------------
<pre>
<b>SweetDialog.alertThree(Context,Title,Message,Icon,setCancelable,PositiveButtonText,NegativeButtonText,NeutralButtonText,OnClick)</b>

<b>Example</b>
<i>SweetDialog.alertThree(this,"Title","Messages",0,false,"Ok",
    "Cancle","Remind me later",object : DialogActionThree {
	override fun positiveAction(dialog: DialogInterface, position: Int) {
		Do your work for Positive Button
        }
	override fun negativeAction(dialog: DialogInterface, position: Int) {
            	Do your work for Negative Button
        }

 override fun neutralAction(dialog: DialogInterface, position: Int) {
		Do your work for Neutral Button		
        }
   })</i>
    </pre>

<b>Simple List Alert Dialog</b>
------------------------
<pre>
<b>SweetDialog.alertList(Context,Title,List of Array,Icon,setCancelable,listOnClick)</b>

<b>Example</b>
<i>val listData = arrayOf("A", "B", "C", "D", "E", "F")

SweetDialog.alertList(this,"Title",listData,0,false,object : DialogListAction {
    	override fun listItemClick(dialog: DialogInterface, position: Int) {
        	Do your work when list item clicked.
    }
})</i>
<b>Note : you should have string type of list in array</b>
</pre>


<b>Single Choice Alert with Two Button</b>
-----------------------------------
<pre>
<b>SweetDialog.alertSingleChoice(Context,Title,List of Array,Icon,setCancelable,PositiveButtonText,NegativeButtonText,OnClick,listOnClick)</b>

<b>Example</b>
<i>val listData = arrayOf("A", "B", "C", "D", "E", "F")

SweetDialog.alertSingleChoice(this,"Title",listData,0,false,"Ok","Cancel",
object : DialogActionTwo {
  	override fun positiveAction(dialog: DialogInterface, position: Int){
		Do your work for Positive Button
        }

override fun negativeAction(dialog: DialogInterface, position: Int) {
            Do your work for Negative Button
        }

    },
object : DialogListAction {
        override fun itemAction(dialog: DialogInterface, position: Int) {
            Do your work when item clicked.
    }
  })</i>
  <b>Note : you should have string type of list in array.</b>
  </pre>


<b>Multi Choice Alert with Two Button</b>
----------------------------------
<pre>
<b>SweetDialog.alertMultiChoice(Context,Title,List of Array,boolean list of Array,Icon,setCancelable,PositiveButtonText,NegativeButtonText,OnClick,listOnClick)</b>

<b>Example</b>
<i>val listData = arrayOf("A", "B", "C", "D", "E", "F")

val boolArray = booleanArrayOf(false,false,false,false,false,false)

SweetDialog.alertMultiChoice(this, "Title", listData, boolListData, 0, false, "Ok", "Cancel",
object : DialogActionTwo {
        override fun positiveAction(dialog: DialogInterface, position: Int){
            Do your work for Positive Button
        }
        override fun negativeAction(dialog: DialogInterface, position: Int){
            Do your work for Negative Button
        }
    },

 object : DialogMultiListAction {
        override fun itemAction(dialog: DialogInterface?, position: Int, checked: Boolean) {
            Do your work when item clicked.
        }

    })
</i>
<b>Note : you should have string type list of data in array.</b>
<b>Note : you should have boolean type of list in array.</b>
<b>Note : both list size should be same or both list item element should equal.</b>
</pre>

<b>Custom Alert Dialog</b>
-------------------
<pre>
<b>SweetDialog.alertCustom(Context,setCancelable,UiControlPassToEndDeveloper)</b>

<b>Example</b>
<i>SweetDialog.alertCustom(this, false, object : CustomDialog {

   override fun positive(positiveUi: TextView) {
  //Positive Button Ui Control to End Developer
      positiveUi.setText("Ok")
      positiveUi.setTextColor("Ok")
      positiveUi.getText("Ok")
      positiveUi.setTextColor(R.color.Red)
      //more as you can do
    }

   override fun negative(negativeUi: TextView) {
  //Negative Button Ui Control to End Developer
          negativeUi.setText("Ok")
          negativeUi.setTextColor("Ok")
          negativeUi.getText("Ok")
          negativeUi.setTextColor(R.color.Red)
          //more as you can do
    }

   override fun layout(layoutUi: LinearLayout) {
	
  //Dialog Layout Ui Control to End Developer
        layoutUi.backgroundTintList = context.resources.getColorStateList(R.color.TransparentBlack)
        //more as you can do
    }

   override fun message(messageUi: TextView) {
	
  //Message TextView Ui Control to End Developer
              messageUi.text = message
              messageUi.textSize = msgSize
              messageUi.setTextColor(msgColor)
              messageUi.ellipsize = msgEllipsize
              messageUi.isSingleLine = msgSingleLine
              messageUi.setBackgroundColor(msgBackColor)
              messageUi.setTypeface(msgFontType, msgFontStyle)
              messageUi.setPadding(msgPadLeft, msgPadRight, msgPadTop, msgPadBottom)
               //more as you can do
  }

   override fun title(titleUi: TextView) {
	//Title TextView Ui Control to End Developer
            titleUi.text = title
            titleUi.setTextColor(titleColor)
            titleUi.textSize = titleSize
            titleUi.setTypeface(titleFontType,titleFontStyle)
            titleUi.setPadding(titlePadLeft,titlePadRight,titlePadTop,titlePadBottom)
            titleUi.setBackgroundColor(titleBackColor)
            titleUi.ellipsize = Text
            //more as you can do
    }

})</i>
</pre>
