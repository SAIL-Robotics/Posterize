/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.edmodo.cropper;

public final class R {
    public static final class attr {
        /** <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int aspectRatioX=0x7f010002;
        /** <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int aspectRatioY=0x7f010003;
        /** <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>rectangle</code></td><td>0</td><td></td></tr>
<tr><td><code>oval</code></td><td>1</td><td></td></tr>
</table>
         */
        public static int cropShape=0x7f010006;
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static int fixAspectRatio=0x7f010001;
        /** <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>on</code></td><td>2</td><td></td></tr>
<tr><td><code>onTouch</code></td><td>1</td><td></td></tr>
<tr><td><code>off</code></td><td>0</td><td></td></tr>
</table>
         */
        public static int guidelines=0x7f010000;
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static int imageResource=0x7f010004;
        /** <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>centerInside</code></td><td>0</td><td></td></tr>
<tr><td><code>fitCenter</code></td><td>1</td><td></td></tr>
</table>
         */
        public static int scaleType=0x7f010005;
    }
    public static final class id {
        public static int CropOverlayView=0x7f030008;
        public static int ImageView_image=0x7f030007;
        public static int centerInside=0x7f030003;
        public static int fitCenter=0x7f030004;
        public static int off=0x7f030000;
        public static int on=0x7f030001;
        public static int onTouch=0x7f030002;
        public static int oval=0x7f030005;
        public static int rectangle=0x7f030006;
    }
    public static final class layout {
        public static int crop_image_view=0x7f020000;
    }
    public static final class styleable {
        /** Attributes that can be used with a CropImageView.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #CropImageView_aspectRatioX com.edmodo.cropper:aspectRatioX}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_aspectRatioY com.edmodo.cropper:aspectRatioY}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_cropShape com.edmodo.cropper:cropShape}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_fixAspectRatio com.edmodo.cropper:fixAspectRatio}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_guidelines com.edmodo.cropper:guidelines}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_imageResource com.edmodo.cropper:imageResource}</code></td><td></td></tr>
           <tr><td><code>{@link #CropImageView_scaleType com.edmodo.cropper:scaleType}</code></td><td></td></tr>
           </table>
           @see #CropImageView_aspectRatioX
           @see #CropImageView_aspectRatioY
           @see #CropImageView_cropShape
           @see #CropImageView_fixAspectRatio
           @see #CropImageView_guidelines
           @see #CropImageView_imageResource
           @see #CropImageView_scaleType
         */
        public static final int[] CropImageView = {
            0x7f010000, 0x7f010001, 0x7f010002, 0x7f010003,
            0x7f010004, 0x7f010005, 0x7f010006
        };
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#aspectRatioX}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.edmodo.cropper:aspectRatioX
        */
        public static int CropImageView_aspectRatioX = 2;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#aspectRatioY}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.edmodo.cropper:aspectRatioY
        */
        public static int CropImageView_aspectRatioY = 3;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#cropShape}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>rectangle</code></td><td>0</td><td></td></tr>
<tr><td><code>oval</code></td><td>1</td><td></td></tr>
</table>
          @attr name com.edmodo.cropper:cropShape
        */
        public static int CropImageView_cropShape = 6;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#fixAspectRatio}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.edmodo.cropper:fixAspectRatio
        */
        public static int CropImageView_fixAspectRatio = 1;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#guidelines}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>on</code></td><td>2</td><td></td></tr>
<tr><td><code>onTouch</code></td><td>1</td><td></td></tr>
<tr><td><code>off</code></td><td>0</td><td></td></tr>
</table>
          @attr name com.edmodo.cropper:guidelines
        */
        public static int CropImageView_guidelines = 0;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#imageResource}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.edmodo.cropper:imageResource
        */
        public static int CropImageView_imageResource = 4;
        /**
          <p>This symbol is the offset where the {@link com.edmodo.cropper.R.attr#scaleType}
          attribute's value can be found in the {@link #CropImageView} array.


          <p>Must be one of the following constant values.</p>
<table>
<colgroup align="left" />
<colgroup align="left" />
<colgroup align="left" />
<tr><th>Constant</th><th>Value</th><th>Description</th></tr>
<tr><td><code>centerInside</code></td><td>0</td><td></td></tr>
<tr><td><code>fitCenter</code></td><td>1</td><td></td></tr>
</table>
          @attr name com.edmodo.cropper:scaleType
        */
        public static int CropImageView_scaleType = 5;
    };
}
