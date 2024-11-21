package com.arr.arcprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class ArcProgressIndicator extends View {

    private float strokeWidth = 26f;
    private float textSize = 70f;

    private int minProgress = 0;
    private int maxProgress = 100;

    private int textColor = Color.BLACK;
    private int indicatorColor = Color.GREEN;
    private int trackColor = Color.GRAY;

    private String centerText;
    private String subtitleText = "";

    private Paint textPaint;
    private Paint indicatorPaint;
    private Paint trackPaint;

    private RectF arcRect = new RectF();

    public ArcProgressIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // diseño del indicador
        indicatorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        indicatorPaint.setColor(indicatorColor);
        indicatorPaint.setStyle(Paint.Style.STROKE);
        indicatorPaint.setStrokeWidth(strokeWidth);
        indicatorPaint.setStrokeCap(Paint.Cap.ROUND);

        // diseño del fondo del indicador
        trackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        trackPaint.setColor(trackColor);
        trackPaint.setStyle(Paint.Style.STROKE);
        trackPaint.setStrokeWidth(strokeWidth);
        trackPaint.setStrokeCap(Paint.Cap.ROUND);

        // dibujar el texto en el centro del progress
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);

        // atrributes
        if (attrs != null) {
            TypedArray array =
                    getContext()
                            .obtainStyledAttributes(attrs, R.styleable.CircularProgressIndicator);
            try {
                // tamaño del texto
                setTextSize(
                        array.getDimension(
                                R.styleable.CircularProgressIndicator_textSize, textSize));
                // color del indicador
                setColorIndicator(
                        array.getColor(
                                R.styleable.CircularProgressIndicator_colorIndicator,
                                indicatorColor));
                // ancho del indicador
                setStrokeWidth(
                        array.getDimension(
                                R.styleable.CircularProgressIndicator_strokeWidth, strokeWidth));
                // texto
                setCenterText(array.getString(R.styleable.CircularProgressIndicator_centerText));

                // color de texto
                setTextColor(
                        array.getColor(R.styleable.CircularProgressIndicator_textColor, textColor));
            } finally {
                array.recycle();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth(); // obtener ancho
        int height = getHeight(); // obtener alto

        // ajustar el radio considerando el tamaño
        int radius = Math.min(width, height) / 2 - (int) strokeWidth / 2;

        // Ajuste del RectF para el arco
        arcRect.set(
                getWidth() / 2f - radius,
                getHeight() / 2f - radius,
                getWidth() / 2f + radius,
                getHeight() / 2f + radius);

        // crear la barra de progreso circular
        arcIndicator(canvas);

        // crear el texto
        textCenter(canvas);
    }

    private void arcIndicator(Canvas canvas) {
        canvas.drawArc(arcRect, -220, 260, false, trackPaint);

        // Dibuja el progreso
        float progressSweepAngle = 260 * (minProgress / 100f);
        canvas.drawArc(arcRect, -220, progressSweepAngle, false, indicatorPaint);
    }

    private void textCenter(Canvas canvas) {
        // Dibuja el texto en el centro
        if (centerText != null) {
            canvas.drawText(
                    centerText,
                    getWidth() / 2f,
                    getHeight() / 2f - (textPaint.descent() + textPaint.ascent()) / 2,
                    textPaint);
        }
    }

    // tamaño del texto en el centro de progress
    public void setTextSize(float size) {
        this.textSize = size;
        textPaint.setTextSize(size);
        invalidate();
    }

    // color de texto
    public void setTextColor(int color) {
        this.textColor = color;
        textPaint.setColor(color);
        invalidate();
    }

    public void setColorIndicator(int color) {
        this.indicatorColor = color;
        indicatorPaint.setColor(color);
        invalidate();
    }

    public void setCenterText(String text) {
        if (text != null && !text.isEmpty()) {
            this.centerText = text;
        }
        invalidate();
    }

    public void setProgress(int progress) {
        this.minProgress = Math.min(progress, maxProgress);
        invalidate();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        invalidate();
    }
}
