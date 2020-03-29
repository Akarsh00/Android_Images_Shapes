package com.askitloud.retrofitdemo.stickerlib.def;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;


import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

public class ImageConverter {

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    public static Bitmap getCirculerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        canvas.drawArc(rectF, 500, 500, true, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static Bitmap getHeartBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        float width = output.getWidth();
        float height = output.getWidth();
        Path path = new Path();


        // Starting point
        path.moveTo(width / 2, height / 5);

        // Upper left path
        path.cubicTo(5 * width / 14, 0,
                0, height / 15,
                width / 28, 2 * height / 5);

        // Lower left path
        path.cubicTo(width / 14, 2 * height / 3,
                3 * width / 7, 5 * height / 6,
                width / 2, height);

        // Lower right path
        path.cubicTo(4 * width / 7, 5 * height / 6,
                13 * width / 14, 2 * height / 3,
                27 * width / 28, 2 * height / 5);

        // Upper right path
        path.cubicTo(width, height / 15,
                9 * width / 14, 0,
                width / 2, height / 5);

        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(output, 0, 0, paint);
        return output;

    }


    public static Path createHeartItem(float top, float size) {
        Path path = new Path();
        path.moveTo(top, top + size / 4);
        path.quadTo(top, top, top + size / 4, top);
        path.quadTo(top + size / 2, top, top + size / 2, top + size / 4);
        path.quadTo(top + size / 2, top, top + size * 3 / 4, top);
        path.quadTo(top + size, top, top + size, top + size / 4);
        path.quadTo(top + size, top + size / 2, top + size * 3 / 4, top + size * 3 / 4);
        path.lineTo(top + size / 2, top + size);
        path.lineTo(top + size / 4, top + size * 3 / 4);
        path.quadTo(top, top + size / 2, top, top + size / 4);
        return path;
    }


    public static Bitmap getTriangleBitmap(Bitmap bitmap, int radius) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        Path path = new Path();
        path.addPath(getTriangle(0, output.getWidth(), output.getHeight()));
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return output;
    }

    public static Bitmap getReverseTriangleBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        Path path = new Path();
        path.addPath(getReverseTriangle(0, output.getWidth(), output.getHeight()));
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return output;
    }

    public static Bitmap rhombus(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        int halfWidth = output.getWidth() / 2;
        int x = 0;
        int y = 0;
        Path triangle = new Path();
        triangle.moveTo(0, bitmap.getHeight() / 2);
        triangle.lineTo(bitmap.getWidth() / 2, bitmap.getHeight());
        triangle.lineTo(bitmap.getWidth(), bitmap.getHeight() / 2);
        triangle.lineTo(bitmap.getWidth() / 2, 0);

        triangle.close();

        final Paint paint = new Paint();
        canvas.drawPath(triangle, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return output;
    }


    public static Bitmap pentagon(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        List<PointF> pointFS = createRegularPentagonPolygon(output.getWidth(), output.getHeight());
        Path wallpath = new Path();
        wallpath.reset(); // only needed when reusing this path for a new build

        for (int i = 0; i < pointFS.size(); i++) {
            if (i == 0) {
                wallpath.moveTo(pointFS.get(0).x, pointFS.get(0).y);

            } else {
                wallpath.lineTo(pointFS.get(i).x, pointFS.get(i).y);
            }
        }
        canvas.drawPath(wallpath, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return rotate(output, -90);
    }


    public static Bitmap rotate(Bitmap src, int angle) {
        // create new matrix for transformation
        Matrix matrix = new Matrix();
        matrix.setRotate(angle);
        Bitmap rotated = Bitmap.createBitmap(src, 0, 0,
                src.getWidth(), src.getHeight(),
                matrix, true);
        return rotated;
    }


    private static Path getTriangle(int offset, int width, int height) {
        Path triangle = new Path();
        triangle.moveTo(0, height);
        triangle.lineTo(width, height);
        triangle.lineTo(width / 2, 0);
        triangle.close();
        return triangle;
    }

    private static Path getReverseTriangle(int offset, int width, int height) {
        Path triangle = new Path();
        triangle.lineTo(0, 0);
        triangle.lineTo(width, 0);
        triangle.lineTo(width / 2, height);
        triangle.close();
        return triangle;
    }


    public static List<PointF> createRegularPentagonPolygon(float width, float height) {

        final float section = (float) (2.0 * Math.PI / 5);
        float radius = width / 2;
        float centerX = width / 2;
        float centerY = height / 2;
        List<PointF> pointList = new ArrayList<>();
        int pentagon = 5;
        for (int i = 1; i <= pentagon; i++) {
            pointList.add(new PointF((float) (centerX + radius * Math.cos(section * i)), (float) (centerY + radius * Math.sin(section * i))));
        }

        return pointList;
    }


    private static Path createStarBySize(Bitmap bmp, int steps) {
        float halfWidth = bmp.getWidth() / 2.0F;
        float bigRadius = halfWidth;
        float radius = halfWidth / 2.0F;
        float degreesPerStep = (float) Math.toRadians(360.0F / (float) steps);
        float halfDegreesPerStep = degreesPerStep / 2.0F;
        Path ret = new Path();
        ret.setFillType(Path.FillType.EVEN_ODD);
        float max = (float) (2.0F* Math.PI);
        ret.moveTo( bmp.getWidth(), halfWidth);
        for (double step = 0; step < max; step += degreesPerStep) {
            ret.lineTo((float)(halfWidth + bigRadius * Math.cos(step)), (float)(halfWidth + bigRadius * Math.sin(step)));
            ret.lineTo((float)(halfWidth + radius * Math.cos(step + halfDegreesPerStep)), (float)(halfWidth + radius * Math.sin(step + halfDegreesPerStep)));
        }
        ret.close();

        return ret;
    }


    public static Bitmap getStar(Bitmap bitmap,int l) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        Path path = new Path();
        path.addPath(createStarBySize(bitmap,l));
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return output;
    }
}